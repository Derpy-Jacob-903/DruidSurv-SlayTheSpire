package druidsurv.cards.powers;

import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsAction;
import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.PersistFields;
import com.evacipated.cardcrawl.mod.stslib.variables.ExhaustiveVariable;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.EmptyDeckShuffleAction;
import com.megacrit.cardcrawl.actions.common.ShuffleAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;

import java.util.ArrayList;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.*;

public class ArchersInstinct extends AbstractEasyCard {

    public final static String ID = makeID("QuincyPick");
    // intellij stuff skill, self, uncommon

    public ArchersInstinct() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF, "ArchersInstinct_CardArt");
        tags.add(druidsurv.cards.cardvars.CardTags.HEROIC);
        tags.add(druidsurv.cards.cardvars.CardTags.BCSPOWER);
        PersistFields.setBaseValue(this, 2);
        ExhaustiveVariable.setBaseValue(this, 2);
        this.setCardBack(cardSubType.POWER);
    }

    public ArchersInstinct(String id, int i, CardType cardType, CardRarity cardRarity, CardTarget cardTarget) {
        super(id, i, cardType, cardRarity, cardTarget);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        ArrayList<AbstractCard> myCardsList = new ArrayList<>();

        // Shuffle deck if draw pile is empty
        if (p.drawPile.size() < magicNumber) {
            addToBot(new EmptyDeckShuffleAction());
            addToBot(new ShuffleAction(AbstractDungeon.player.drawPile, false));
        }

        // Add cards dynamically based on `numberOfCards`
        for (int i = 0; i < magicNumber; i++) {
            if (p.drawPile.size() > i) { // Check if there's a card at index `i`
                myCardsList.add(p.drawPile.getNCardFromTop(i));
            } else {
                // If draw pile doesn't have enough cards, draw the remaining cards and return
                atb(new DrawCardAction(magicNumber - i));
                return;
            }
        }

        // Execute SelectCardsAction with the list of cards
        atb(new SelectCardsAction(myCardsList, 1, cardStrings.EXTENDED_DESCRIPTION[0], (cards) -> {
            for (AbstractCard card : cards) {
                myCardsList.remove(card); // Don't move the selected card to the bottom of the deck
                //p.drawPile.addToHand(card); // Add the selected card to the hand
            }
            for (AbstractCard card : myCardsList) {
                p.drawPile.moveToBottomOfDeck(card); // Move remaining cards to the bottom of the deck
            }
            atb(new DrawCardAction(1));
        }));
    }



    @Override
    public void upp() {
        upgradeBaseCost(0);
    }
}