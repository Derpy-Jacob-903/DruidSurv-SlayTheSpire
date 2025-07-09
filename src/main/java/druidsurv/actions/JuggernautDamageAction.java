package druidsurv.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.PlayTopCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.GetAllInBattleInstances;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.FlashAtkImgEffect;
import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.PurgeField; //<== using this..

import java.util.UUID;
/// Replays a card on kill
public class JuggernautDamageAction extends AbstractGameAction {
    private int increaseAmount;
    private DamageInfo info;
    private UUID uuid;
    private Boolean allDamage;

    public JuggernautDamageAction(AbstractCreature target, DamageInfo info, UUID targetUUID, Boolean allDamage) {
        this.info = info;
        this.setValues(target, info);
        this.actionType = ActionType.DAMAGE;
        this.duration = 0.1F;
        this.uuid = targetUUID;
        this.allDamage = allDamage;
    }

    public void update() {

        if (this.duration == 0.1F) {
            if (!this.allDamage ) {
                if (this.target == null) {
                    this.target = AbstractDungeon.getMonsters().getRandomMonster((AbstractMonster) null, true, AbstractDungeon.cardRandomRng);
                }
                AbstractDungeon.effectList.add(new FlashAtkImgEffect(this.target.hb.cX, this.target.hb.cY, AttackEffect.SLASH_HORIZONTAL));
                this.target.damage(this.info);

                if ((this.target.isDying || this.target.currentHealth <= 0) && !this.target.halfDead) {
                    for (AbstractCard c : GetAllInBattleInstances.get(this.uuid)) {
                        AbstractCard d = c.makeStatEquivalentCopy();
                        PurgeField.purge.set(d, true);
                        AbstractDungeon.player.drawPile.group.add(AbstractDungeon.player.drawPile.group.size(), d);
                        addToBot(new PlayTopCardAction(this.target, false));
                        break;
                    }
                }
            }
            else
            {
                for (int i = 0; i < AbstractDungeon.getMonsters().monsters.size(); i++) {
                    this.target = AbstractDungeon.getMonsters().monsters.get(i);
                    if (this.target == null) {
                        this.target = AbstractDungeon.getMonsters().getRandomMonster((AbstractMonster) null, true, AbstractDungeon.cardRandomRng);
                    }
                    AbstractDungeon.effectList.add(new FlashAtkImgEffect(this.target.hb.cX, this.target.hb.cY, AttackEffect.SLASH_HORIZONTAL));
                    this.target.damage(this.info);

                    if ((this.target.isDying || this.target.currentHealth <= 0) && !this.target.halfDead) {
                        for (AbstractCard c : GetAllInBattleInstances.get(this.uuid)) {
                            AbstractCard d = c.makeStatEquivalentCopy();
                            PurgeField.purge.set(d, true);
                            AbstractDungeon.player.drawPile.group.add(AbstractDungeon.player.drawPile.group.size(), d);
                            addToBot(new PlayTopCardAction(this.target, false));
                            break;
                        }
                    }
                }
            }
        }
        if (AbstractDungeon.getCurrRoom().monsters.areMonstersBasicallyDead()) {
        AbstractDungeon.actionManager.clearPostCombatActions();
        }
        this.tickDuration();
    }
}