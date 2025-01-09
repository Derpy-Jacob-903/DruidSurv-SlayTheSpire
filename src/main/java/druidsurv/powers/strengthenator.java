package druidsurv.powers;
import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.HealthBarRenderPower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

import static druidsurv.ModFile.makeID;

public class strengthenator extends AbstractEasyPower implements HealthBarRenderPower {
        public static final String POWER_ID = makeID("Strengthenator");

        private static final PowerType TYPE = PowerType.BUFF;

        private static final boolean TURN_BASED = false;

        public strengthenator(AbstractCreature owner, int amount) {
            super(POWER_ID, "Strengthenator", TYPE, false, owner, amount);
        }

        public void atStartOfTurn()
        {
            addToBot((AbstractGameAction)new ApplyPowerAction(this.owner, this.owner, (AbstractPower)new StrengthPower(this.owner, 1), 1, true, AbstractGameAction.AttackEffect.NONE));
        }

        public void updateDescription() {
            this.description = this.DESCRIPTIONS[0] + this.amount + this.DESCRIPTIONS[1];
        }

        public AbstractPower makeCopy() {
            return new strengthenator(this.owner, this.amount);
        }

        public int getHealthBarAmount() {
            return this.amount;
        }

        public Color getColor() {
            return Color.LIME;
        }
    }
