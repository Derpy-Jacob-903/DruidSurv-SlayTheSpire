package druidsurv.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.powers.AbstractEasyPower;
import druidsurv.powers.bloons.BasicBloonPower;

///
public class ReduceBloonHealthAction extends ReducePowerAction {
    private String powerID;
    private AbstractPower powerInstance;
    private OnPopEffect onPopEffect = OnPopEffect.Null;

    public ReduceBloonHealthAction(AbstractCreature target, AbstractCreature source, AbstractPower power, int amount) {
        super(target, source, power, amount);
        this.powerInstance = power;
    }

    public ReduceBloonHealthAction(AbstractCreature target, AbstractCreature source, AbstractPower power, int amount, OnPopEffect onPopEffect) {
        super(target, source, power, amount);
        this.onPopEffect = onPopEffect;
        this.powerInstance = power;
    }

    public void update() {
        if (this.duration == this.startDuration) {
            AbstractEasyPower reduceMe = null;
            if (this.powerInstance != null) {
                reduceMe = (AbstractEasyPower) this.powerInstance;
            }
            if (reduceMe != null) { //help
                if (this.amount < reduceMe.amount2) {
                    reducePower2(this.amount, reduceMe);
                    reduceMe.updateDescription();
                    AbstractDungeon.onModifyPower();
                } else {
                    this.addToTop(new RemoveSpecificPowerAction(this.target, this.source, reduceMe));

                    if (this.onPopEffect == OnPopEffect.Volatile) {
                        addToTop(new DamageAction(AbstractDungeon.player, new DamageInfo(AbstractDungeon.player, 10, DamageInfo.DamageType.THORNS)));
                        addToTop(new DamageAllEnemiesAction(AbstractDungeon.player, 10, DamageInfo.DamageType.THORNS, AttackEffect.FIRE));
                    } else if (this.onPopEffect == OnPopEffect.NestedBlue) {
                        addToTop(new ApplyPowerAction(target, AbstractDungeon.player, new BasicBloonPower(target, 1, 6), 1, true, AbstractGameAction.AttackEffect.NONE));
                    }
                }
            }
        }
        this.tickDuration();
    }

    public void reducePower2(int reduceAmount, AbstractEasyPower reduceMe) {
        if (reduceMe.amount2 - reduceAmount <= 0) {
            //reduceMe.fontScale = 8.0F;
            reduceMe.amount2 = 0;
        } else {
            //reduceMe.fontScale = 8.0F;
            reduceMe.amount2 -= reduceAmount;
        }
    }

    public enum OnPopEffect {
        Null,
        Volatile,
        Toxic,
        NestedBlue,
        NestedGreen,
        NestedYellow
    }
}

