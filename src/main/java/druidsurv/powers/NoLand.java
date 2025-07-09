package druidsurv.powers;
import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DiscardSpecificCardAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

import java.util.ArrayList;

import static druidsurv.ModFile.makeID;
import static druidsurv.cards.cardvars.CardTags.RELOAD;

public class NoLand extends AbstractEasyPower {
        public static final String POWER_ID = makeID("NoLand");

        private static final PowerType TYPE = PowerType.BUFF;

        private static final boolean TURN_BASED = false;

        public NoLand(AbstractCreature owner, int amount) {
            super(POWER_ID, "No Land", TYPE, false, owner, amount);
        }


    public void atStartOfTurn() {
        addToBot((AbstractGameAction) new ReducePowerAction(this.owner, this.owner, this, 1));
    }


    public void updateDescription() {
            this.description = this.DESCRIPTIONS[0] + this.amount + this.DESCRIPTIONS[1];
        }

        public AbstractPower makeCopy() {
            return new NoLand(this.owner, this.amount);
        }

        public int getHealthBarAmount() {
            return this.amount;
        }
    }
