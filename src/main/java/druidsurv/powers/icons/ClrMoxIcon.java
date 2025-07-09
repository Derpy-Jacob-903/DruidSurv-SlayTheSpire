package druidsurv.powers.icons;

import com.evacipated.cardcrawl.mod.stslib.icons.AbstractCustomIcon;

import static druidsurv.ModFile.makeID;
import static druidsurv.ModFile.makeImagePath;
import static druidsurv.util.TexLoader.getTexture;

public class ClrMoxIcon extends AbstractCustomIcon {
    public static final String ID = makeID("CMoxI"); //[CMoxIIcon]
    private static ClrMoxIcon singleton;

    public ClrMoxIcon() {
        super(ID, getTexture(makeImagePath("512/text_cMox.png")));
    }

    public static ClrMoxIcon get()
    {
        if (singleton == null) {
            singleton = new ClrMoxIcon();
        }
        return singleton;
    }
}
