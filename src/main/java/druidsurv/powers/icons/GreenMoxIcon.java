package druidsurv.powers.icons;

import com.evacipated.cardcrawl.mod.stslib.icons.AbstractCustomIcon;

import static druidsurv.ModFile.makeID;
import static druidsurv.ModFile.makeImagePath;
import static druidsurv.util.TexLoader.getTexture;

public class GreenMoxIcon extends AbstractCustomIcon {
    public static final String ID = makeID("GMoxI"); //[GMoxIIcon]
    private static GreenMoxIcon singleton;

    public GreenMoxIcon() {
        super(ID, getTexture(makeImagePath("512/text_gMox.png")));
    }

    public static GreenMoxIcon get()
    {
        if (singleton == null) {
            singleton = new GreenMoxIcon();
        }
        return singleton;
    }
}
