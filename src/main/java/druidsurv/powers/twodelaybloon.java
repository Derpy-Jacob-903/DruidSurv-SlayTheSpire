package druidsurv.powers;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.BarricadePower;
import com.megacrit.cardcrawl.powers.NextTurnBlockPower;

import static druidsurv.ModFile.makeID;

public class twodelaybloon extends AbstractEasyPower{
    private static final PowerType TYPE = PowerType.DEBUFF;

    private static final boolean TURN_BASED = false;

    public static final String POWER_ID = makeID("2DelayBloon");

    public twodelaybloon(AbstractCreature owner, int amount) {
        super(POWER_ID, "Incoming Bloon", TYPE, TURN_BASED, owner, amount);
    }
    public twodelaybloon(String id, String name, AbstractCreature owner, int amount ) {
        super(id, name, TYPE, false, owner, amount);
    }
    public void atStartOfTurn() {
        addToBot((AbstractGameAction)new ApplyPowerAction(this.owner, this.owner, (AbstractPower)new onedelaybloon(this.owner, amount), amount, true, AbstractGameAction.AttackEffect.NONE));
        addToBot((AbstractGameAction)new ReducePowerAction(this.owner, this.owner, this, amount));
    }

    public void onAttack(DamageInfo info, int damageAmount, AbstractCreature target)
    {
        if (target != this.owner)
        {
            addToBot((AbstractGameAction)new ReducePowerAction(this.owner, this.owner, this, damageAmount));
        }
    }

    public void onGainedBlock(float blockAmount)
    {
        addToBot((AbstractGameAction)new ReducePowerAction(this.owner, this.owner, (AbstractPower)this, (int)blockAmount));
    }

    public void updateDescription()
    {
        if (DESCRIPTIONS != null && DESCRIPTIONS.length > 1)
        { this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1]; }
        else { this.description = "Description not available."; }
    }

    public AbstractPower makeCopy() {
        return new twodelaybloon(this.owner, this.amount);
    }
}