package druidsurv.powers;
import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.HealthBarRenderPower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.BarricadePower;
import com.megacrit.cardcrawl.powers.NextTurnBlockPower;

import static com.megacrit.cardcrawl.powers.AbstractPower.DESCRIPTIONS;
import static druidsurv.ModFile.makeID;

public class onedelaybloon extends AbstractEasyPower implements HealthBarRenderPower {
        public static final String POWER_ID = makeID("1DelayBloon");

        private static final PowerType TYPE = PowerType.DEBUFF;

        private static final boolean TURN_BASED = false;

        public onedelaybloon(AbstractCreature owner, int amount) {
            super(POWER_ID, "Incoming Bloon", TYPE, false, owner, amount);
        }

        //s
        public onedelaybloon(String id, String name, AbstractCreature owner, int amount ) {
            super(id, name, TYPE, false, owner, amount);
        }

        public void atStartOfTurn() {
            addToBot((AbstractGameAction)new ApplyPowerAction(this.owner, this.owner, (AbstractPower)new zerodelaybloon(this.owner, amount), 1, true, AbstractGameAction.AttackEffect.NONE));
            addToBot((AbstractGameAction)new ReducePowerAction(this.owner, this.owner, this, amount));
        }

        public void onGainedBlock(float blockAmount)
        {
            addToBot((AbstractGameAction)new ReducePowerAction(this.owner, this.owner, (AbstractPower)this, (int)blockAmount));
        }

    public void onAttack(DamageInfo info, int damageAmount, AbstractCreature target)
    {
        if (target != this.owner)
        {
            addToBot((AbstractGameAction)new ReducePowerAction(this.owner, this.owner, this, damageAmount));
        }
    }

    public void updateDescription()
    {
        if (DESCRIPTIONS != null && DESCRIPTIONS.length > 1)
        { this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1]; }
        else { this.description = "Description not available."; }
    }
        public AbstractPower makeCopy() {
            return new onedelaybloon(this.owner, this.amount);
        }

        public int getHealthBarAmount() {
            int tmp = 0;
            if (this.owner.hasPower(BarricadePower.POWER_ID))
            {
                tmp += this.owner.currentBlock;
                tmp -= this.owner.getPower(zerodelaybloon.POWER_ID).amount;
            }
            if (this.owner.hasPower(NextTurnBlockPower.POWER_ID))
            {
                tmp += this.owner.getPower(NextTurnBlockPower.POWER_ID).amount;
            }
            return this.amount - tmp;
        }

        public Color getColor() {
            return Color.YELLOW;
        }
    }
