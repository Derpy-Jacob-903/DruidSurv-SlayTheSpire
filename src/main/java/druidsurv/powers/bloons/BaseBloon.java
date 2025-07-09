package druidsurv.powers.bloons;
import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.NonStackablePower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.powers.AbstractEasyPower;
import druidsurv.actions.ReduceBloonHealthAction;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.atb;
import static druidsurv.util.Wiz.removePower;

public class BaseBloon extends AbstractEasyPower implements NonStackablePower {
        public static final String POWER_ID = makeID("BaseBloon");

        private static final PowerType TYPE = PowerType.DEBUFF;

        private static final boolean TURN_BASED = true;

        public BaseBloon(AbstractCreature owner, int amount) {
            super(POWER_ID, "Attacking Bloon", TYPE, TURN_BASED, owner, amount);
        }

        //s
        public BaseBloon(String id, String name, AbstractCreature owner, int amount ) {
            super(id, name, TYPE, TURN_BASED, owner, amount);
        }

        public BaseBloon(String powerId, String name, PowerType type, boolean b, AbstractCreature owner, int delay, int health) {
            super(powerId, name, TYPE, TURN_BASED, owner, delay, health);
        }

        public BaseBloon(String powerId, AbstractCreature owner, int delay, int health, String name) {
            super(powerId, name, TYPE, TURN_BASED, owner, delay, health);
        }

    public void atStartOfTurn()
    {
        if (this.amount < 1)
        {
            if (amount2 > 74.5)
            {
                atb(new DamageAction(owner, new DamageInfo(AbstractDungeon.player, amount2, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
            }
            else
            {
                atb(new DamageAction(owner, new DamageInfo(AbstractDungeon.player, amount2, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
            }
            removePower(this);
        }
        else {this.amount--;}
    }

    public void onGainedBlock(float blockAmount)
    {
        addToBot((AbstractGameAction) new ReduceBloonHealthAction(this.owner, this.owner, (AbstractPower)this, (int)blockAmount));
    }

    public void onAttack(DamageInfo info, int damageAmount, AbstractCreature target)
    {
        if (target != this.owner) //Not self damage (i.e. Bloons)
        {
            addToBot((AbstractGameAction)new ReduceBloonHealthAction(this.owner, this.owner, this, info.output));
        }
    }

    public void updateDescription()
    {
        //if (DESCRIPTIONS != null && DESCRIPTIONS.length > 2)
        //{ this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1] + this.amount2 + DESCRIPTIONS[2]; }
        //else {
        this.description = "Description not available. NL Delay: " + this.amount + " NL Health: " + this.amount2;
    }


    public AbstractPower makeCopy()
    {
        return new BaseBloon(this.owner, this.amount);
    }
}
