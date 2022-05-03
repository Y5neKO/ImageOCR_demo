import net.sourceforge.tess4j.Tesseract;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageReadTest {
    public static String shibie(String imgPath, boolean ZH_CN){
        try {
            File imageFile = new File(imgPath);
            if (!imageFile.exists()){
                return "不存在";
            }
            BufferedImage textImage = ImageIO.read(imageFile);
            Tesseract instance = new Tesseract();
            instance.setDatapath(System.getProperty("user.dir"));
            System.out.println(System.getProperty("user.dir"));
            if (ZH_CN){
                instance.setLanguage("chi_sim");
            }
            String result = null;
            result = instance.doOCR(textImage);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return "识别出错";
        }
    }

    public static void main(String[] args){
        if (!(args.length == 0)){
            for(String arguments: args){
                String test = shibie(arguments,true);
                System.out.println(test);
                System.out.println("--------------------");
            }
        }else {
            System.out.println("请输入图片路径");
        }
    }
}
