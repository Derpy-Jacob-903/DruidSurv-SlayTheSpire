package druidsurv.powers.icons;

import com.evacipated.cardcrawl.mod.stslib.icons.AbstractCustomIcon;

import static druidsurv.ModFile.makeID;
import static druidsurv.ModFile.makeImagePath;
import static druidsurv.util.TexLoader.getTexture;

public class BloontoniumIcon extends AbstractCustomIcon {
    public static final String ID = makeID("Bloontonium");
    private static BloontoniumIcon singleton;

    public BloontoniumIcon() {
        super(ID, getTexture(makeImagePath("512/text_bloontonium.png")));
    }

    public static BloontoniumIcon get()
    {
        if (singleton == null) {
            singleton = new BloontoniumIcon();
        }
        return singleton;
    }
}
