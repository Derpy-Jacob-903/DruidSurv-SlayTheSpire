package druidsurv.relics;

import druidsurv.CharacterFile;
import druidsurv.cards.colorless.Wolf;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.makeInHand;

public class CueBall extends AbstractEasyRelic {
    public static final String ID = makeID("FutureCrystal");
    private boolean activated;

    public CueBall() {
        super(ID, RelicTier.BOSS, LandingSound.MAGICAL, CharacterFile.Enums.DRUIDSURV_COLOR);
    }

    //hard coded into Large Bloons
}
