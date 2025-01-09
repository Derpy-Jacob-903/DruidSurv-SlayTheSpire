package druidsurv.powers;
import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.HealthBarRenderPower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static druidsurv.ModFile.makeID;

public class zerodelaybloon extends AbstractEasyPower implements HealthBarRenderPower {
        public static final String POWER_ID = makeID("0DelayBloon");

        private static final AbstractPower.PowerType TYPE = PowerType.DEBUFF;

        private static final boolean TURN_BASED = false;

        public zerodelaybloon(AbstractCreature owner, int amount) {
            super(POWER_ID, "Imminent Bloon", TYPE, false, owner, amount);
        }

        public void atStartOfTurn() {
            addToBot((AbstractGameAction)new DamageAction((AbstractCreature)this.owner, new DamageInfo(AbstractDungeon.player, this.amount, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
            //addToBot((AbstractGameAction)new LoseHPAction(this.owner, this.owner, this.amount, AbstractGameAction.AttackEffect.BLUNT_LIGHT));
            addToBot((AbstractGameAction)new ReducePowerAction(this.owner, this.owner, this, amount));
        }
        public void onAttack(DamageInfo info, int damageAmount, AbstractCreature target)
        {
            if (target != this.owner)
            {
                addToBot((AbstractGameAction)new ReducePowerAction(this.owner, this.owner, this, damageAmount));
            }
        }

        public void updateDescription() {
            this.description = this.DESCRIPTIONS[0] + this.amount + this.DESCRIPTIONS[1];
        }

        public AbstractPower makeCopy() {
            return new zerodelaybloon(this.owner, this.amount);
        }

        public int getHealthBarAmount() {
            return this.amount - this.owner.currentBlock;
        }

        public Color getColor() {
            return Color.PINK;
        }
    }