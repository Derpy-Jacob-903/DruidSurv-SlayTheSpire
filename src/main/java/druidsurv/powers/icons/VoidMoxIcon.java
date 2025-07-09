package druidsurv.powers.icons;

import com.evacipated.cardcrawl.mod.stslib.icons.AbstractCustomIcon;

import static druidsurv.ModFile.makeID;
import static druidsurv.ModFile.makeImagePath;
import static druidsurv.util.TexLoader.getTexture;

public class VoidMoxIcon extends AbstractCustomIcon {
    public static final String ID = makeID("CMoxI"); //[CMoxIIcon]
    private static VoidMoxIcon singleton;

    public VoidMoxIcon() {
        super(ID, getTexture(makeImagePath("512/text_VMox.png")));
    }

    public static VoidMoxIcon get()
    {
        if (singleton == null) {
            singleton = new VoidMoxIcon();
        }
        return singleton;
    }
}
