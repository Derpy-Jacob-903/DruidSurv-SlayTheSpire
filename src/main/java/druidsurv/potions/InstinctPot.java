package druidsurv.potions;

import basemod.BaseMod;
import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.helpers.PowerTip;
import druidsurv.CharacterFile;
import druidsurv.ModFile;
import druidsurv.NemCharacterFile;
import druidsurv.actions.MakeTempCardAtBottomOfDeckAction2;

import java.util.ArrayList;
import java.util.Collections;

import static druidsurv.ModFile.NemCharacterColor;
import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.*;

public class InstinctPot extends AbstractEasyPotion {
    public static String ID = makeID("InstinctPot");

    public InstinctPot() {
        super(ID, PotionRarity.COMMON, PotionSize.CARD, new Color(0.352f, 0.38f, 0.421f, 1f), new Color(1, .711f, 0, 1), new Color(1, .711f, 0, 1), CharacterFile.Enums.DRUIDSURV, ModFile.characterColor);
    }

    public int getPotency(int ascensionlevel) {
        return 1;
    }

    public void use(AbstractCreature creature) {
        ArrayList<AbstractCard> myCardsList = new ArrayList<>();
        ArrayList<AbstractCard> eligibleCardsList = getCardsMatchingPredicate(c -> c.color == CharacterFile.Enums.DRUIDSURV_COLOR || c.color == CharacterFile.Enums.NEMDRUID_COLOR || c.color == CharacterFile.Enums.STRIKER_COLOR ||c.color == AbstractCard.CardColor.COLORLESS, true);
        Collections.shuffle(eligibleCardsList);
        for (int i = 0; i < getPotency(); i++) {
            eligibleCardsList.get(i).costForTurn = 0;
            myCardsList.add(eligibleCardsList.get(i));
        }
        // Execute SelectCardsAction with the list of cards
        atb(new SelectCardsAction(myCardsList, 3, "ArchersInstinct.cardStrings.EXTENDED_DESCRIPTION[0]", (cards) -> {
            for (AbstractCard card : cards) {
                for (int i = 0; i < getPotency(); i++) {
                    myCardsList.remove(card); // Don't move the selected card to the bottom of the deck
                    //AbstractDungeon.player.drawPile.addToTop(card); // Add the selected card to the hand
                    att(new MakeTempCardInHandAction(cards.get(0))); // Move remaining cards to the bottom of the deck
                }
            }
            for (AbstractCard card : myCardsList) {
                for (int i = 0; i < getPotency(); i++){
                    att(new MakeTempCardAtBottomOfDeckAction2(1, card)); // Move remaining cards to the bottom of the deck
                }
            }
        }));
    }

    public String getDescription() {
        return strings.DESCRIPTIONS[0] + potency + strings.DESCRIPTIONS[1];
    }

    public void addAdditionalTips() {
        tips.add(new PowerTip(BaseMod.getKeywordTitle(makeID("todo")), BaseMod.getKeywordDescription(makeID("todo"))));
    }
}