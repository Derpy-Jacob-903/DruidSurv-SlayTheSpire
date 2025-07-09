package druidsurv.potions;

import basemod.BaseMod;
import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.WeakPower;
import druidsurv.CharacterFile;
import druidsurv.ModFile;
import druidsurv.powers.ManaShieldPower;
import druidsurv.util.CascadeHandler;

import static druidsurv.ModFile.makeID;

public class ManaShieldPot extends AbstractEasyPotion {
    public static String ID = makeID("ManaShieldPot");

    public ManaShieldPot() {
        super(ID, PotionRarity.COMMON, PotionSize.M, new Color(.094f, 0.459f, 0.71f, 1f), new Color(.094f, 0.459f, 0.71f, 1f), new Color(.094f, 0.451f, 0.18f, 1f));
    }

    public int getPotency(int ascensionlevel) {
        return 12;
    }

    public void use(AbstractCreature target) {
        addToBot((AbstractGameAction)new ApplyPowerAction(AbstractDungeon.player, (AbstractCreature) AbstractDungeon.player, (AbstractPower)new ManaShieldPower(AbstractDungeon.player, this.potency), this.potency));
    }

    public String getDescription() {
        return strings.DESCRIPTIONS[0] + potency + strings.DESCRIPTIONS[1];
    }

    public void addAdditionalTips() {
        tips.add(new PowerTip(BaseMod.getKeywordTitle(makeID("todo")), BaseMod.getKeywordDescription(makeID("todo"))));
    }
}