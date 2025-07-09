package druidsurv.powers.icons;

import com.evacipated.cardcrawl.mod.stslib.icons.AbstractCustomIcon;

import static druidsurv.ModFile.makeID;
import static druidsurv.ModFile.makeImagePath;
import static druidsurv.util.TexLoader.getTexture;

public class BlueMoxIcon extends AbstractCustomIcon {
    public static final String ID = makeID("BMoxI"); //[BMoxIIcon]
    private static BlueMoxIcon singleton;

    public BlueMoxIcon() {
        super(ID, getTexture(makeImagePath("512/text_bMox.png")));
    }

    public static BlueMoxIcon get()
    {
        if (singleton == null) {
            singleton = new BlueMoxIcon();
        }
        return singleton;
    }
}
