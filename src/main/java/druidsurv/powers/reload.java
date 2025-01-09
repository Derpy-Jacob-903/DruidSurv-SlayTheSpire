package druidsurv.powers;
import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

import java.util.ArrayList;

import static druidsurv.ModFile.makeID;
import static druidsurv.cards.cardvars.CardTags.RELOAD;

public class reload extends AbstractEasyPower {
        public static final String POWER_ID = makeID("Reload");

        private static final PowerType TYPE = PowerType.BUFF;

        private static final boolean TURN_BASED = false;

        public reload(AbstractCreature owner, int amount) {
            super(POWER_ID, "Reloading", TYPE, false, owner, amount);
        }

    public boolean exhaustPileHasReloadCard() {
        for (AbstractCard card : AbstractDungeon.player.exhaustPile.group) {
            if (card.tags.contains(RELOAD)) {
                return true; // A card with RELOAD tag is found
            }
        }
        return false; // No card with RELOAD tag was found
    }

    public void atStartOfTurn() {
        CardGroup e = AbstractDungeon.player.exhaustPile;
        ArrayList<AbstractCard> myCardsList = new ArrayList<>();
        int totalCards = AbstractDungeon.player.discardPile.size();
        if (exhaustPileHasReloadCard())
        {
            for (int i = 0; i < amount; i++) {
                AbstractCard tmp = e.getRandomCard(true);

                // Ensure 'tmp' is reassigned within the loop
                while (tmp != null && !tmp.tags.contains(RELOAD)) {
                    tmp = e.getRandomCard(true);
                }

                // If 'tmp' is not null and contains the 'RELOAD' tag, move it to the discard pile
                if (tmp != null && tmp.tags.contains(RELOAD)) {
                    tmp.moveToDiscardPile();
                }
            }
        }
        addToBot((AbstractGameAction) new ReducePowerAction(this.owner, this.owner, this, amount));
    }


    public void updateDescription() {
            this.description = this.DESCRIPTIONS[0] + this.amount + this.DESCRIPTIONS[1];
        }

        public AbstractPower makeCopy() {
            return new reload(this.owner, this.amount);
        }

        public int getHealthBarAmount() {
            return this.amount;
        }

        public Color getColor() {
            return Color.PINK;
        }
    }
