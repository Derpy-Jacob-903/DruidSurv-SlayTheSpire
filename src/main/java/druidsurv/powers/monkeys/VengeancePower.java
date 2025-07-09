package druidsurv.powers.monkeys;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.powers.AbstractEasyPower;
import druidsurv.powers.ThornPower;

import static druidsurv.ModFile.makeID;

public class VengeancePower extends AbstractEasyPower {
    public static final String POWER_ID = makeID("Vengeance");

    private static final PowerType TYPE = PowerType.DEBUFF;

    private static final boolean TURN_BASED = true;

    public VengeancePower(AbstractCreature owner, int amount) {
        super(POWER_ID, "Vengeance",  TYPE, true, owner, amount);
        this.isTurnBased = false;
    }

    public void updateDescription() {
        this.description = this.DESCRIPTIONS[0] + this.amount + this.DESCRIPTIONS[1];
    }

    public int onAttackedToChangeDamage(DamageInfo info, int damageAmount) {
        if (damageAmount > 0 && info.type == DamageInfo.DamageType.NORMAL) {
            addToBot((AbstractGameAction)new ApplyPowerAction(this.owner, info.owner, (AbstractPower)new ThornPower(this.owner, this.amount), this.amount, true, AbstractGameAction.AttackEffect.NONE));
        }
        return damageAmount;
    }

    public AbstractPower makeCopy() {
        return new VengeancePower(this.owner, this.amount);
    }
}
