package druidsurv.powers.monkeys;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.AttackDamageRandomEnemyAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.cards.abilities.PerceptiveShot;
import druidsurv.cards.cardvars.CardTags;
import druidsurv.powers.AbstractEasyPower;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.atb;

public class PerceptiveShotPower extends AbstractEasyPower {
        public static final String POWER_ID = makeID("PerceptiveShotPower");

        private static final PowerType TYPE = PowerType.BUFF;

        private static final boolean TURN_BASED = false;

        public PerceptiveShotPower(AbstractCreature owner, int amount) {
            super(POWER_ID, "Perceptive Shot", TYPE, false, owner, amount);
            this.canGoNegative = false;
        }

        public void onPlayCard(AbstractCard card, AbstractMonster m) {
            if (card.tags.contains(CardTags.BLOON))
            {
                if (m != null) {
                    atb(new DamageAction(m, new DamageInfo(AbstractDungeon.player, amount, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
                }
                else {
                    PerceptiveShot dummy = new PerceptiveShot();
                    dummy.damage = this.amount;
                    atb(new AttackDamageRandomEnemyAction(dummy, AbstractGameAction.AttackEffect.SLASH_VERTICAL));
                }
            }
        }

        public void updateDescription() {
            this.description = this.DESCRIPTIONS[0] + this.amount + this.DESCRIPTIONS[1];
        }

        public AbstractPower makeCopy() {
            return new PerceptiveShotPower(this.owner, this.amount);
        }
    }
