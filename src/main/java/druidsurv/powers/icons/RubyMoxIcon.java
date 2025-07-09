package druidsurv.powers.icons;

import com.evacipated.cardcrawl.mod.stslib.icons.AbstractCustomIcon;

import static druidsurv.ModFile.makeID;
import static druidsurv.ModFile.makeImagePath;
import static druidsurv.util.TexLoader.getTexture;

public class RubyMoxIcon extends AbstractCustomIcon {
    public static final String ID = makeID("RMoxI"); //[RMoxIIcon]
    private static RubyMoxIcon singleton;

    public RubyMoxIcon() {
        super(ID, getTexture(makeImagePath("512/text_rMox.png")));
    }

    public static RubyMoxIcon get()
    {
        if (singleton == null) {
            singleton = new RubyMoxIcon();
        }
        return singleton;
    }
}
