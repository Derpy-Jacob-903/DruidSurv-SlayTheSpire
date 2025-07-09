package druidsurv.potions;

import basemod.BaseMod;
import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.powers.StrengthPower;
import druidsurv.CharacterFile;
import druidsurv.ModFile;
import druidsurv.util.CascadeHandler;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.adp;
import static druidsurv.util.Wiz.applyToSelf;

public class QuickReadyPotion extends AbstractEasyPotion {
    public static String ID = makeID("QuickReady");

    public QuickReadyPotion() {
        super(ID, PotionRarity.UNCOMMON, PotionSize.S, new Color(1f, 1f, 1f, 1f), new Color(1f, 1f, 1f, 1f), new Color(0f, 0f, 0f, 1f), CharacterFile.Enums.DRUIDSURV, ModFile.characterColor);
        this.isThrown = true;
        this.targetRequired = true;
    }

    public int getPotency(int ascensionlevel) {
        return 1;
    }

    public void use(AbstractCreature creature) {
        CascadeHandler s = new CascadeHandler();
        for (int j = 0; j < getPotency(); j++) {
            s.cascade(creature);
        }
    }

    public String getDescription() {
        return strings.DESCRIPTIONS[0] + potency + strings.DESCRIPTIONS[1];
    }

    public void addAdditionalTips() {
        tips.add(new PowerTip(BaseMod.getKeywordTitle(makeID("todo")), BaseMod.getKeywordDescription(makeID("todo"))));
    }
}