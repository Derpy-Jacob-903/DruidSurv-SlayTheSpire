package druidsurv.actions;

/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.FlameBarrierPower;
/*    */ import com.megacrit.cardcrawl.vfx.combat.FlashAtkImgEffect;


///
///
///
@Deprecated
public class DefenderAttackAction extends AbstractGameAction {
        /*    */    private DamageInfo info;
        /*    */    private static final float DURATION = 0.1F;
                    private boolean muteSfx = false;

    public DefenderAttackAction(AbstractCreature target, AbstractCreature source, DamageInfo info) {
        this.info = info;
        setValues(target, info);
        this.actionType = AbstractGameAction.ActionType.DAMAGE;
        this.duration = 0.1F;
    }

    public void update() {
        if (this.duration == 0.1F && this.target != null) {
                if ((((AbstractMonster)this.target).isDying || this.target.currentHealth <= 0) && !this.target.halfDead) {
                    //Add Block
                    addToBot(new GainBlockAction(source, info.output));
                    addToBot(new ApplyPowerAction(this.source, this.source, new FlameBarrierPower(this.source, info.output), info.output));
                }
                else
                {
                    AbstractDungeon.effectList.add(new FlashAtkImgEffect(this.target.hb.cX, this.target.hb.cY, this.attackEffect, this.muteSfx));
                    addToBot(new DamageAction(this.target, this.info));
                }
        }
        tickDuration();
    }
}
