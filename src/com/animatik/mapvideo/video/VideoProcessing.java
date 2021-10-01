package com.animatik.mapvideo.video;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class VideoProcessing {
private FFmpegFrameGrabber grabber;
private ArrayList<BufferedImage> rendered_video;
private  double frame_rate;

    public VideoProcessing(String filename) throws FFmpegFrameGrabber.Exception {
        preRender(new File(filename));
    }


    public boolean preRender(File file) throws FFmpegFrameGrabber.Exception {
    grabber = new FFmpegFrameGrabber(file);
    rendered_video = new ArrayList<>();
    frame_rate = grabber.getFrameRate();
    grabber.start();
    Frame i;
        for (int j = 0; j < grabber.getLengthInFrames() ; j++) {
            i = grabber.grab();
            BufferedImage bi = new Java2DFrameConverter().convert(i);
            rendered_video.add(bi);
        grabber.stop();

        }

    return  true;
    }




}
