package gao.word;

import com.aspose.words.*;

import java.io.FileInputStream;
import java.util.*;
import java.util.List;


/**
 * 对word模板填充数据，并合并成一个word
 */
public class POIMergeDocUtil {

	public static void main(String[] args) throws Exception {

		String templatePath = "D:\\巡检\\公文\\template.doc";
		String tm2 = "D:\\巡检\\公文\\巡检记录单-20200101.doc";
		String tm3 = "D:\\巡检\\公文\\巡检记录单-20200102.doc";

		FileInputStream is2 = new FileInputStream(tm2);
		FileInputStream is3 = new FileInputStream(tm3);
		Document doc1 = new Document(is2);
		Document do2c = new Document(is3);
		appendDocument(doc1,do2c,true);
	}
	public static Document appendDocument(Document mainDoc, Document addDoc, boolean isPortrait) { //设置书签，指定文档拼接的位置
		String bookmark = "aa";
		DocumentBuilder builder = null;
		try {
			builder = new DocumentBuilder(mainDoc);
			BookmarkCollection bms = mainDoc.getRange().getBookmarks();
			Bookmark bm = bms.get(bookmark);
			if (bm != null) {
				builder.moveToBookmark(bookmark, true, false);
				builder.writeln();
				Node insertAfterNode = builder.getCurrentParagraph().getPreviousSibling();
				insertDocumentAfterNode(insertAfterNode, mainDoc, addDoc);
			}//设置纸张大小
			builder.getPageSetup().setPaperSize(PaperSize.A4);
			if (isPortrait) {
				//纵向纸张，
				builder.getPageSetup().setOrientation(Orientation.PORTRAIT);
				builder.insertBreak(BreakType.SECTION_BREAK_NEW_PAGE);
			} else {
				//横向
				builder.getPageSetup().setOrientation(Orientation.LANDSCAPE);
				builder.insertBreak(BreakType.SECTION_BREAK_NEW_PAGE);
			}
			//builder.insertBreak(BreakType.PAGE_BREAK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mainDoc;
	}

	/**
	 * @Description 向书签后插入文档
	 * @param mainDoc 主文档
	 * @param tobeInserted 拼接的文档
	 * @param bookmark 书签
	 * @Return com.aspose.words.Document
	 * @Author Mr.Walloce
	 * @Date 2019/7/27 18:33
	 */
	private static Document insertDocumentAfterBookMark(Document mainDoc, Document tobeInserted, String bookmark)
			throws Exception {
		if (mainDoc == null) {
			return null;
		} else if (tobeInserted == null) {
			return mainDoc;
		} else {
			//构建新文档
			DocumentBuilder mainDocBuilder = new DocumentBuilder(mainDoc);
			if (bookmark != null && bookmark.length() > 0) {
				//获取到书签
				BookmarkCollection bms = mainDoc.getRange().getBookmarks();
				Bookmark bm = bms.get(bookmark);
				if (bm != null) {
					mainDocBuilder.moveToBookmark(bookmark, true, false);
					mainDocBuilder.writeln();
					//获取到插入的位置
					Node insertAfterNode = mainDocBuilder.getCurrentParagraph().getPreviousSibling();
					insertDocumentAfterNode(insertAfterNode, mainDoc, tobeInserted);
				}
			} else {
				appendDoc(mainDoc, tobeInserted, true);
			}

			return mainDoc;
		}
	}

	/**
	 * @Description TODO
	 * @param insertAfterNode 插入的位置
	 * @param mainDoc
	 * @param srcDoc
	 * @Return void
	 * @Author Mr.Walloce
	 * @Date 2019/7/27 14:51
	 */
	private static void insertDocumentAfterNode(Node insertAfterNode, Document mainDoc, Document srcDoc)
			throws Exception {
		if (insertAfterNode.getNodeType() != 8 & insertAfterNode.getNodeType() != 5) {
			throw new Exception("The destination node should be either a paragraph or table.");
		} else {
			CompositeNode dstStory = insertAfterNode.getParentNode();

			while (null != srcDoc.getLastSection().getBody().getLastParagraph()
					&& !srcDoc.getLastSection().getBody().getLastParagraph().hasChildNodes()) {
				srcDoc.getLastSection().getBody().getLastParagraph().remove();
			}

			NodeImporter importer = new NodeImporter(srcDoc, mainDoc, 1);
			int sectCount = srcDoc.getSections().getCount();

			for (int sectIndex = 0; sectIndex < sectCount; ++sectIndex) {
				Section srcSection = srcDoc.getSections().get(sectIndex);
				int nodeCount = srcSection.getBody().getChildNodes().getCount();

				for (int nodeIndex = 0; nodeIndex < nodeCount; ++nodeIndex) {
					Node srcNode = srcSection.getBody().getChildNodes().get(nodeIndex);
					Node newNode = importer.importNode(srcNode, true);
					dstStory.insertAfter(newNode, insertAfterNode);
					insertAfterNode = newNode;
				}
			}

		}
	}

	/**
	 * @Description 文档拼接
	 * @param dstDoc
	 * @param srcDoc
	 * @param includeSection
	 * @Return void
	 * @Author Mr.Walloce
	 * @Date 2019/7/27 14:53
	 */
	private static void appendDoc(Document dstDoc, Document srcDoc, boolean includeSection) throws Exception {
		if (includeSection) {
			Iterator<Section> var3 = srcDoc.getSections().iterator();
			while (var3.hasNext()) {
				Section srcSection = (Section) var3.next();
				Node dstNode = dstDoc.importNode(srcSection, true, 0);
				dstDoc.appendChild(dstNode);
			}
		} else {
			Node node = dstDoc.getLastSection().getBody().getLastParagraph();
			if (node == null) {
				node = new Paragraph(srcDoc);
				dstDoc.getLastSection().getBody().appendChild(node);
			}

			if (node.getNodeType() != 8 & node.getNodeType() != 5) {
				throw new Exception("Use appendDoc(dstDoc, srcDoc, true) instead of appendDoc(dstDoc, srcDoc, false)");
			}

			insertDocumentAfterNode(node, dstDoc, srcDoc);
		}
	}
}