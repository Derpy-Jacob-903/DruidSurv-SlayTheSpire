package druidsurv.util.dailymods;

import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.daily.mods.AbstractDailyMod;
import com.megacrit.cardcrawl.localization.RunModStrings;
import druidsurv.util.TexLoader;

import static druidsurv.ModFile.makeID;
import static druidsurv.ModFile.makeRelicPath;

public class Improvised2 extends AbstractDailyMod {
    public static final String ID2 = makeID("TodoItemOld");
    public static final String ID = makeID("Improvised2");
    public static final String NAME;
    public static final String DESC;
    private static final RunModStrings modStrings;

    static {
        modStrings = CardCrawlGame.languagePack.getRunModString(ID);
        NAME = modStrings.NAME;
        DESC = modStrings.DESCRIPTION;
    }

    public Improvised2() {
        super(ID, NAME, DESC, null, true);
        this.img = TexLoader.getTexture(makeRelicPath(ID2.replace(modID + ":", "") + ".png"));
    }
}