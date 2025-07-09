package druidsurv.cards.powers;

import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.EmptyDeckShuffleAction;
import com.megacrit.cardcrawl.actions.common.ShuffleAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.powers.ManaShieldPower;

import java.util.ArrayList;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.atb;

public class NaturesClarity extends AbstractEasyCard {

    public final static String ID = makeID("");
    // intellij stuff skill, self, uncommon

    public NaturesClarity() {
        super(ID, 1, CardType.SKILL, CardRarity.RARE, CardTarget.SELF, "NaturesClarity_CardArt");
        baseMagicNumber = 1;
        magicNumber = baseMagicNumber;
        baseBlock = 6;
        exhaust = true;
        tags.add(druidsurv.cards.cardvars.CardTags.BCSPOWER);
        this.setCardBack(cardSubType.POWER);
    }

    public NaturesClarity(String id, int i, CardType cardType, CardRarity cardRarity, CardTarget cardTarget) {
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
            for (AbstractCard card : cards) {
                addToBot((AbstractGameAction)new ApplyPowerAction(p, p, (AbstractPower)new ManaShieldPower(p, card.cost*block), card.cost*block, true, AbstractGameAction.AttackEffect.SHIELD));
                return;
            }
        }));

    }


    @Override
    public void upp() {
        upgradeBlock(5);
    }
}