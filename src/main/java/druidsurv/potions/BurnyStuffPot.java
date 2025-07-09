package druidsurv.potions;

import basemod.BaseMod;
import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.CharacterFile;
import druidsurv.ModFile;
import druidsurv.powers.OnFire;
import druidsurv.util.CascadeHandler;

import static druidsurv.ModFile.makeID;

public class BurnyStuffPot extends AbstractEasyPotion {
    public static String ID = makeID("OnFirePot");

    public BurnyStuffPot() {
        super(ID, PotionRarity.COMMON, PotionSize.SPHERE, new Color(.094f, 0.459f, 0.71f, 1f), new Color(.094f, 0.459f, 0.71f, 1f), new Color(.094f, 0.451f, 0.18f, 1f));
        this.isThrown = true;
        this.targetRequired = true;
    }

    public int getPotency(int ascensionlevel) {
        return 1;
    }

    public void use(AbstractCreature target) {
        this.addToTop((AbstractGameAction)new ApplyPowerAction(target, AbstractDungeon.player, (AbstractPower)new OnFire(target, 9), 9, true, AbstractGameAction.AttackEffect.FIRE));
    }

    public String getDescription() {
        return strings.DESCRIPTIONS[0] + potency + strings.DESCRIPTIONS[1];
    }

    public void addAdditionalTips() {
        tips.add(new PowerTip(BaseMod.getKeywordTitle(makeID("todo")), BaseMod.getKeywordDescription(makeID("todo"))));
    }
}