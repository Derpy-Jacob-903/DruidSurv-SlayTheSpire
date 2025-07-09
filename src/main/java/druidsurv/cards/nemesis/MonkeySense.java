package druidsurv.cards.nemesis;

import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.EmptyDeckShuffleAction;
import com.megacrit.cardcrawl.actions.common.ShuffleAction;
import com.megacrit.cardcrawl.actions.utility.ScryAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.CharacterFile;
import druidsurv.NemCharacterFile;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.cards.AbstractPowerCostCard;
import druidsurv.powers.mox.BlueMox;
import druidsurv.powers.mox.GreenMox;
import druidsurv.powers.mox.RubyMox;
import druidsurv.util.Wiz;

import java.util.ArrayList;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.*;

public class MonkeySense extends AbstractEasyCard {
    public final static String ID = makeID("MonkeySense");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public MonkeySense() {
        super(ID, 1, CardType.SKILL, CardRarity.BASIC, CardTarget.SELF, CharacterFile.Enums.NEMDRUID_COLOR, "RarePower_CardArt");
        baseDraw = 3;
        baseMagicNumber = magicNumber = 2;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {

        for (int i = 0; i < Wiz.p().discardPile.size(); i++) {

            if (p.discardPile.getNCardFromTop(i).color == CharacterFile.Enums.NEMDRUID_MOX_COLOR ) {shuffleIn(p.discardPile.getNCardFromTop(i));}
        }
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
            atb(new SelectCardsAction(myCardsList, 1, cardStrings.EXTENDED_DESCRIPTION[0], (cards) -> { //NullPointerException
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
    public static int countCards() {
        int count = 0;
        if (AbstractDungeon.player.hasPower(BlueMox.POWER_ID)) {
            if (AbstractDungeon.player.getPower(BlueMox.POWER_ID).amount > 0) {
                count = AbstractDungeon.player.getPower(BlueMox.POWER_ID).amount;
            }
        }
        return count;
    }

    public void applyPowers() {
        int realBaseDamage = this.baseMagicNumber;
        this.baseMagicNumber += countCards();
        super.applyPowers();
        this.baseMagicNumber = realBaseDamage;
        this.isDamageModified = (this.damage != this.baseDamage);
    }

    @Override
    public void upp() {
        upgradeMagicNumber(1);
    }
}