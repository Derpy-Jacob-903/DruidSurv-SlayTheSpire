package druidsurv.powers;
import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.HealthBarRenderPower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.WeakPower;

import static druidsurv.ModFile.makeID;

//Crazy ass class name :skull:
//public class weakeninggas extends AbstractEasyPower implements HealthBarRenderPower {
public class WeakBloonPower extends AbstractEasyPower implements HealthBarRenderPower {
        public static final String POWER_ID = makeID("WeakBloonPower");

        private static final PowerType TYPE = PowerType.BUFF;

        private static final boolean TURN_BASED = false;

        public WeakBloonPower(AbstractCreature owner, int amount) {
            super(POWER_ID, "Weakening Gas Bloon", TYPE, false, owner, amount);
        }

        public void atStartOfTurn()
        {
            addToBot((AbstractGameAction)new ReducePowerAction(this.owner, this.owner, this, 15));
        }

        public int onAttacked(DamageInfo info, int damageAmount)
        {
            addToBot((AbstractGameAction)new ApplyPowerAction(info.owner, this.owner, (AbstractPower)new WeakPower(info.owner, 1, false), 1, true, AbstractGameAction.AttackEffect.NONE));
            return damageAmount;
        }

        public void updateDescription() {
            this.description = this.DESCRIPTIONS[0] + this.amount;
        }

        public AbstractPower makeCopy() {
            return new WeakBloonPower(this.owner, this.amount);
        }

        public int getHealthBarAmount() {
            return this.amount;
        }

        public Color getColor() {
            return Color.PURPLE;
        }
    }
