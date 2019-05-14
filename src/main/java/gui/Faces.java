package gui;

import javax.swing.*;
import java.awt.*;

public class Faces
{
//    private static final Image IMAGE_SMILING_FACE_WITH_SMILING_EYES = new ImageIcon("src/main/resources/image/emoji/smiling-face-with-smiling-eyes.png").getImage();
    private static final Image IMAGE_SMILING_FACE_WITH_SMILING_EYES = new ImageIcon("src/main/resources/image/emoji/paddyHappy.png").getImage();
    private static final Image IMAGE_SMILING_FACE_WITH_SUNGLASSES = new ImageIcon("src/main/resources/image/emoji/paddyYouWon.png").getImage();
    private static final Image IMAGE_DIZZY_FACE = new ImageIcon("src/main/resources/image/emoji/dizzy-face.png").getImage();
    private static final Image IMAGE_FEARFUL_FACE = new ImageIcon("src/main/resources/image/emoji/paddyUhhOh.png").getImage();
    private static final Image IMAGE_SMIRKING_FACE = new ImageIcon("src/main/resources/image/emoji/paddyHeyThere.png").getImage();
    private static final Image IMAGE_BOMB = new ImageIcon("src/main/resources/image/emoji/paddyUhhOhBomb.png").getImage();
    private static final Image IMAGE_TRIANGULAR_FLAG = new ImageIcon("src/main/resources/image/emoji/triangular-flag.png").getImage();
    private static final Image IMAGE_PARTY_POPPER = new ImageIcon("src/main/resources/image/emoji/paddyYouWon.png").getImage();
    private static final Image IMAGE_COLLISION = new ImageIcon("src/main/resources/image/emoji/paddyUhhOhBomb.png").getImage();
    private static final Image IMAGE_LEFT_ARROW = new ImageIcon("src/main/resources/image/emoji/left-arrow.png").getImage();
    private static final Image IMAGE_RIGHT_ARROW = new ImageIcon("src/main/resources/image/emoji/right-arrow.png").getImage();

    public Faces()
    {
    }

    public static Image getSmilingFaceWithSmilingEyes()
    {
        Image imageSmilingFaceWithSmilingEyesResize = IMAGE_SMILING_FACE_WITH_SMILING_EYES.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        return imageSmilingFaceWithSmilingEyesResize;
    }

    public static Image getSmilingFaceWithSunglasses()
    {
        Image imageSmilingFaceWithSunglassesResize = IMAGE_SMILING_FACE_WITH_SUNGLASSES.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        return imageSmilingFaceWithSunglassesResize;
    }

    public static Image getDizzyFace()
    {
        Image imageDizzyFaceResize = IMAGE_DIZZY_FACE.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        return imageDizzyFaceResize;
    }

    public static Image getFearfulFace()
    {
        Image imageFearfulFaceResize = IMAGE_FEARFUL_FACE.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        return imageFearfulFaceResize;
    }

    public static Image getSmirkingFace()
    {
        Image imageSmirkingFaceResize = IMAGE_SMIRKING_FACE.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        return imageSmirkingFaceResize;
    }

    public static Image getBomb()
    {
        Image imageEmojiBombResize = IMAGE_BOMB.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        return imageEmojiBombResize;
    }

    public static Image getTriangularFlag()
    {
        Image imageTriangularFlagResize = IMAGE_TRIANGULAR_FLAG.getScaledInstance(35, 35, Image.SCALE_SMOOTH);

        return imageTriangularFlagResize;
    }

    public static Image getPartyPopper()
    {
        Image imagePartyPopperResize = IMAGE_PARTY_POPPER.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        return imagePartyPopperResize;
    }

    public static Image getCollision()
    {
        Image imageCollisionResize = IMAGE_COLLISION.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        return imageCollisionResize;
    }

    public static Image getLeftArrow()
    {
        Image imageLeftArrowResize = IMAGE_LEFT_ARROW.getScaledInstance(20, 20, Image.SCALE_SMOOTH);

        return imageLeftArrowResize;
    }

    public static Image getRightArrow()
    {
        Image imageRightArrowResize = IMAGE_RIGHT_ARROW.getScaledInstance(20, 20, Image.SCALE_SMOOTH);

        return imageRightArrowResize;
    }
}
