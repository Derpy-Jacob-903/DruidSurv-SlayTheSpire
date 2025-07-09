package druidsurv.powers.bloons;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.atb;

public class DoubleBloonPower extends BaseBloon {
        public static final String POWER_ID = makeID("DoubleBloonPower");

        private static final PowerType TYPE = PowerType.DEBUFF;

        private static final boolean TURN_BASED = true;

        public DoubleBloonPower(AbstractCreature owner, int delay, int health) {
            super(POWER_ID, "Red Bloon", TYPE, TURN_BASED, owner, delay, health);
        }

        public DoubleBloonPower(AbstractCreature owner, int delay, int health, String name) {
            super(POWER_ID, "Red Bloon", TYPE, TURN_BASED, owner, delay, health);
        }


        public DoubleBloonPower(String id, String name, AbstractCreature owner, int delay, int health) {
            super(id, name, TYPE, TURN_BASED, owner, delay, health);
        }

    @Override
    public void atStartOfTurn()
    {
        if (this.amount < 1)
        {
            if (amount2 > 74.5)
            {
                atb(new DamageAction(owner, new DamageInfo(AbstractDungeon.player, amount2, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
                atb(new DamageAction(owner, new DamageInfo(AbstractDungeon.player, amount2, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
            }
            else
            {
                atb(new DamageAction(owner, new DamageInfo(AbstractDungeon.player, amount2, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
                atb(new DamageAction(owner, new DamageInfo(AbstractDungeon.player, amount2, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
            }
        }
        else {this.amount--;}
    }
    public AbstractPower makeCopy() {
            return new DoubleBloonPower(this.owner, this.amount, this.amount2);
        }
}
