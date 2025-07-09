package druidsurv.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.vfx.combat.LightningEffect;
import druidsurv.powers.OnFire;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

/// Used for Burny Stuff
public class AttackDamageAndApplyPowerRandomEnemyAction extends AbstractGameAction {
    private final AbstractCard card;
    private final AbstractGameAction.AttackEffect effect;
    private final AbstractPower power;

    public AttackDamageAndApplyPowerRandomEnemyAction(AbstractCard card, AbstractGameAction.AttackEffect effect) {
        this.card = card;
        this.effect = effect;
        this.power = (AbstractPower)new OnFire(target, 9);
    }

    public AttackDamageAndApplyPowerRandomEnemyAction(AbstractCard card, AbstractGameAction.AttackEffect effect, int amount) {
        this.card = card;
        this.effect = effect;
        this.power = (AbstractPower)new OnFire(target, amount);
    }

    public AttackDamageAndApplyPowerRandomEnemyAction(AbstractCard card, AbstractGameAction.AttackEffect effect, AbstractPower power) {
        this.card = card;
        this.effect = effect;
        this.power = power;
    }

    public AttackDamageAndApplyPowerRandomEnemyAction(AbstractCard card) {
        this(card, AttackEffect.NONE);
    }

    public void update() {
        this.target = AbstractDungeon.getMonsters().getRandomMonster((AbstractMonster)null, true, AbstractDungeon.cardRandomRng);
        if (this.target != null) {
            this.card.calculateCardDamage((AbstractMonster)this.target);
            if (AttackEffect.LIGHTNING == this.effect) {
                this.addToTop(new DamageAction(this.target, new DamageInfo(AbstractDungeon.player, this.card.damage, this.card.damageTypeForTurn), AttackEffect.NONE));
                this.addToTop((AbstractGameAction)new ApplyOnFireAction(target, AbstractDungeon.player, power, power.amount, true, AbstractGameAction.AttackEffect.NONE));
                this.addToTop(new SFXAction("ORB_LIGHTNING_EVOKE", 0.1F));
                this.addToTop(new VFXAction(new LightningEffect(this.target.hb.cX, this.target.hb.cY)));
            } else {
                this.addToTop(new DamageAction(this.target, new DamageInfo(AbstractDungeon.player, this.card.damage, this.card.damageTypeForTurn), this.effect));
                addToTop((AbstractGameAction)new ApplyOnFireAction(target, AbstractDungeon.player, power, power.amount, true, AbstractGameAction.AttackEffect.NONE));
            }
        }

        this.isDone = true;
    }
}
