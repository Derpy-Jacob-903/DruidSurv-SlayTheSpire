package druidsurv.powers;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.cards.cardvars.CardTags;

import static druidsurv.ModFile.makeID;

public class ThornPower extends AbstractEasyPower {
        public static final String POWER_ID = makeID("ThornStrength");

        private static final PowerType TYPE = PowerType.BUFF;

        private static final boolean TURN_BASED = false;

        public ThornPower(AbstractCreature owner, int amount) {
            super(POWER_ID, "Thorn Strength", TYPE, false, owner, amount);
            this.canGoNegative = false;
        }

        public float atDamageGive(float damage, DamageInfo.DamageType type, AbstractCard card) {
        if (card.hasTag(CardTags.THORNKIND)) {
            return damage + amount;
        }
        return damage;
    }

        public void updateDescription()
        {
            this.description = this.DESCRIPTIONS[0] + amount + this.DESCRIPTIONS[1];
        }

        public AbstractPower makeCopy() {
            return new ThornPower(this.owner, this.amount);
        }
    }
