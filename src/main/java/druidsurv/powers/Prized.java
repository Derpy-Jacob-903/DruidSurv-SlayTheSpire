package druidsurv.powers;

import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.HealthBarRenderPower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static druidsurv.ModFile.makeID;

public class Prized extends AbstractEasyPower implements HealthBarRenderPower {
    public static final String POWER_ID = makeID("Prized");

    private static final AbstractPower.PowerType TYPE = AbstractPower.PowerType.DEBUFF;

    private static final boolean TURN_BASED = true;

    public Prized(AbstractCreature owner, int amount) {
        super(POWER_ID, "Prized",  TYPE, true, owner, amount);
        this.isTurnBased = false;
        this.priority = 99;
    }

    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
        if (this.amount > 999)
            this.amount = 998;
    }

    public void updateDescription() {
        this.description = this.DESCRIPTIONS[0] + this.amount + this.DESCRIPTIONS[1];
    }

    public int onAttackedToChangeDamage(DamageInfo info, int damageAmount) {
        if (damageAmount > 0 && info.type == DamageInfo.DamageType.NORMAL) {
            int temp = amount;
            addToTop((AbstractGameAction)new ReducePowerAction(this.owner, this.owner, this, amount));
            return damageAmount + temp;
        }
        return damageAmount;
    }

    public AbstractPower makeCopy() {
        return new Prized(this.owner, this.amount);
    }

    public int getHealthBarAmount() {
        return amount;
    }

    public Color getColor() {
        return Color.SLATE;
    }
}
