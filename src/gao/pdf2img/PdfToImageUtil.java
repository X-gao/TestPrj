package gao.pdf2img;
 
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
 
import javax.imageio.ImageIO;
 
import org.icepdf.core.pobjects.Document;
import org.icepdf.core.util.GraphicsRenderingHints;

/**
 * @author 网上资源
 */
public class PdfToImageUtil {
  /**
     * 将pdf文件转成HD jpg图片
     * @param filePath
     * @param path
     */
  private static void pdfToHdJpg(String filePath, String path){
        try {
            Document document = new Document();
            document.setFile(filePath);
            //缩放比例
            float scale = 2.5f;
            //旋转角度
            float rotation = 0f;
            List<BufferedImage> picList = new ArrayList<>();
            for (int i = 0; i < document.getNumberOfPages(); i++) {
                BufferedImage image = (BufferedImage)
                        document.getPageImage(i, GraphicsRenderingHints.SCREEN,
                                org.icepdf.core.pobjects.Page.BOUNDARY_CROPBOX, rotation, scale);
                image.flush();
                picList.add(image);
            }
            yPic(picList,path);
            document.dispose();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
     }

    /** 
     * 将宽度相同的图片，竖向追加在一起 ##注意：宽度必须相同 
     *  
     * @param picList 
     *            文件流数组 
     * @param outPath 
     *            输出路径 
     */
    private static void yPic(List<BufferedImage> picList, String outPath) {// 纵向处理图片  
        if (picList == null || picList.size() <= 0) {
            System.out.println("图片数组为空!");
            return;
        }
        try {
            // 总高度  
            int height = 0,
                    // 总宽度
                    width = 0,
            // 临时的高度 , 或保存偏移高度  
            height1,
                    // 临时的高度，主要保存每个高度
            height2,
                    // 图片的数量  
            picNum = picList.size();
            // 保存每个文件的高度  
            int[] heightArray = new int[picNum];
            // 保存图片流  
            BufferedImage buffer;
            // 保存所有的图片的RGB  
            List<int[]> imgRgb = new ArrayList<>();
            // 保存一张图片中的RGB数据  
            int[] imgRgb2;
            for (int i = 0; i < picNum; i++) {
                buffer = picList.get(i);
                // 图片高度  
                heightArray[i] = height1 = buffer.getHeight();
                if (i == 0) {
                    // 图片宽度
                    width = buffer.getWidth();
                }
                // 获取总高度  
                height += height1;
                // 从图片中读取RGB
                imgRgb2 = new int[width * height1];
                imgRgb2 = buffer
                        .getRGB(0, 0, width, height1, imgRgb2, 0, width);
                imgRgb.add(imgRgb2);
            }
            // 设置偏移高度为0  
            height1 = 0;
            // 生成新图片  
            BufferedImage imageResult = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_BGR);
            for (int i = 0; i < picNum; i++) {
                height2 = heightArray[i];
                if (i != 0){
                    // 计算偏移高度
                    height1 += height2;
                }
                // 写入流中  
                imageResult.setRGB(0, height1, width, height2, imgRgb.get(i),
                        0, width);
            }
            File outFile = new File(outPath);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            // 写图片  
            ImageIO.write(imageResult, "png", out);
            byte[] b = out.toByteArray();
            FileOutputStream output = new FileOutputStream(outFile);
            output.write(b);
            out.close();
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String filePath = "C:\\Users\\花月\\Desktop\\template_20200701103928.pdf";
        String imgPath = "C:\\Users\\花月\\Desktop\\template_20200701103928.png";
        pdfToHdJpg(filePath, imgPath);
    }
}
