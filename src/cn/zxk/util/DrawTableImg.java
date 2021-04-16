package cn.zxk.util;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class DrawTableImg {
	/**
     * 生成图片
     * @param cellsValue 以二维数组形式存放 表格里面的值
     * @param path 文件保存路径
     */
    public void myGraphicsGeneration(String cellsValue[][], String path) {
        // 字体大小
        int fontTitileSize = 15;
        // 横线的行数
        int totalrow = cellsValue.length+1;
        // 竖线的行数
        int totalcol = 0;
        if (cellsValue[0]  != null) {
            totalcol = cellsValue[0].length;
        }
        // 图片宽度
        int imageWidth = 1024;
        // 行高
        int rowheight = 40;
        // 图片高度
        int imageHeight = totalrow*rowheight+50;
        // 起始高度
        int startHeight = 10;
        // 起始宽度
        int startWidth = 10;
        // 单元格宽度
        int colwidth = (int)((imageWidth-20)/totalcol);
        BufferedImage image = new BufferedImage(imageWidth, imageHeight,BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0, imageWidth, imageHeight);
        graphics.setColor(new Color(220,240,240));

        //画横线
        for(int j=0;j<totalrow; j++){
            graphics.setColor(Color.black);
            graphics.drawLine(startWidth, startHeight+(j+1)*rowheight, startWidth+colwidth*totalcol, startHeight+(j+1)*rowheight);
        }
        //画竖线
        for(int k=0;k<totalcol+1;k++){
            graphics.setColor(Color.black);
            graphics.drawLine(startWidth+k*colwidth, startHeight+rowheight, startWidth+k*colwidth, startHeight+rowheight*totalrow);
        }
        //设置字体
        Font font = new Font("微软雅黑",Font.BOLD,fontTitileSize);
        graphics.setFont(font);
        //写标题
        String title = "【运单】";
        graphics.drawString(title, startWidth, startHeight+rowheight-10);
        //写入内容
        for(int n=0;n<cellsValue.length;n++){
                for(int l=0;l<cellsValue[n].length;l++){
                    if (n == 0) {
                        font = new Font("微软雅黑",Font.BOLD,fontTitileSize);
                        graphics.setFont(font);
                    }else if (n > 0 && l >0) {
                        font = new Font("微软雅黑",Font.PLAIN,fontTitileSize);
                        graphics.setFont(font);
                        graphics.setColor(Color.RED);
                    } else {
                        font = new Font("微软雅黑",Font.PLAIN,fontTitileSize);
                        graphics.setFont(font);
                        graphics.setColor(Color.BLACK);
                    }
                graphics.drawString(cellsValue[n][l].toString(), startWidth+colwidth*l+5, startHeight+rowheight*(n+2)-10);
            }
        }
        // 保存图片
        createImage(image, path);
    }

/**
     * 将图片保存到指定位置
     * @param image 缓冲文件类
     * @param fileLocation 文件位置
     */
    public void createImage(BufferedImage image, String fileLocation) {
        try {
            FileOutputStream fos = new FileOutputStream(fileLocation);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
            encoder.encode(image);
            bos.close();
            } catch (Exception e) {
            e.printStackTrace();
            }
    }
    
    public static void mergeImage(String bigPath,String smallPath,String x,String y) throws IOException {

        try {
            BufferedImage small ;
            BufferedImage big = ImageIO.read(new File(bigPath));
            if(smallPath.contains("http")){

                URL url = new URL(smallPath);
                small = ImageIO.read(url);
            }else{
                small = ImageIO.read(new File(smallPath));
            }

            Graphics2D g = big.createGraphics();

            float fx = Float.parseFloat(x);
            float fy = Float.parseFloat(y);
            int x_i = (int)fx;
            int y_i = (int)fy;
            g.drawImage(small, x_i, y_i,small.getWidth(),small.getHeight(), null);
            g.dispose();
            ImageIO.write(big, "png", new File(bigPath));

        } catch (Exception e) {
                e.printStackTrace();
        }

    }

    

    
    
    public static void main(String[] args) {
        DrawTableImg cg = new DrawTableImg();
        BarcodeUtil bu = new BarcodeUtil();
        try {
            String tableData1[][] = {{"","累计用户数","目标值","完成进度","时间进度", "进度差异"}, {"掌厅客户端（户）","469281","1500000","31.2%","33.6%", "-2.4%"}};
            String[][] tableData2 = {{"8月31日（户）","新增用户数","日访问量","累计用户数","环比上月"},
            {"合肥和巢湖","469281","1500000","31.2%","33.6%"},
            {"芜湖","469281","1500000","31.2%","33.6%"},
            {"蚌埠","469281","1500000","31.2%","33.6%"},
            {"淮南","469281","1500000","31.2%","33.6%"},
            {"马鞍山","469281","1500000","31.2%","33.6%"},
            {"淮北","469281","1500000","31.2%","33.6%"}};
            cg.myGraphicsGeneration(tableData1, "D:\\myPic5.jpg");
            bu.generateFile("1234567989", "D:\\myPic4.jpg");
            mergeImage("D:\\myPic4.jpg","D:\\myPic5.jpg","1000","1000");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
