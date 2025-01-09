package druidsurv.cards;

import basemod.cardmods.EtherealMod;
import basemod.cardmods.ExhaustMod;
import basemod.helpers.CardModifierManager;
import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.EmptyDeckShuffleAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.ShuffleAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.ArrayList;
import java.util.Collections;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.*;

public class ArchersInstinct extends AbstractEasyCard {

    public final static String ID = makeID(ArchersInstinct.class.getSimpleName());
    // intellij stuff skill, self, uncommon

    public ArchersInstinct() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        setBackgroundTexture("druidsurvResources/images/512/power_skill.png", "druidsurvResources/images/1024/power_skill.png");
    }

    public ArchersInstinct(String id, int i, CardType cardType, CardRarity cardRarity, CardTarget cardTarget) {
        super(id, i, cardType, cardRarity, cardTarget);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        ArrayList<AbstractCard> myCardsList = new ArrayList<>();

        if (p.drawPile.isEmpty() ) {
            addToBot((AbstractGameAction) new EmptyDeckShuffleAction());
            addToBot((AbstractGameAction) new ShuffleAction(AbstractDungeon.player.drawPile, false));
        }
        // Adding the top card if the draw pile is not empty
        if (!p.drawPile.isEmpty()) {
            myCardsList.add(p.drawPile.getTopCard());
        }

        // Check if the draw pile has more than 1 card before adding the second card
        if (p.drawPile.size() > 1) {
            myCardsList.add(p.drawPile.getNCardFromTop(1));
        } else {
            atb(new DrawCardAction(1));
            return;
        }

        // Check if the draw pile has more than 2 cards before adding the third card
        if (p.drawPile.size() > 2) {
            myCardsList.add(p.drawPile.getNCardFromTop(2));
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