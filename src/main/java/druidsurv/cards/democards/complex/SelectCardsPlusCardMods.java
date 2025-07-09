package druidsurv.cards.democards.complex;

import basemod.AutoAdd;
import basemod.cardmods.EtherealMod;
import basemod.cardmods.ExhaustMod;
import basemod.helpers.CardModifierManager;
import druidsurv.cards.AbstractEasyCard;
import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.ArrayList;
import java.util.Collections;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.*;

@AutoAdd.Ignore
public class SelectCardsPlusCardMods extends AbstractEasyCard {

    public final static String ID = makeID(SelectCardsPlusCardMods.class.getSimpleName());
    // intellij stuff skill, self, uncommon

    public SelectCardsPlusCardMods() {
        super(ID, 1, CardType.SKILL, CardRarity.SPECIAL, CardTarget.SELF);
        setPortraitTextures("druidsurvResources/images/cardui/512/frame_skill_hidden.png", "druidsurvResources/images/cardui/1024/frame_skill_hidden.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        ArrayList<AbstractCard> myCardsList = new ArrayList<>();
        ArrayList<AbstractCard> eligibleCardsList = getCardsMatchingPredicate(c -> c.cost == 0, true);
        Collections.shuffle(eligibleCardsList);
        for (int i = 0; i < 3; i++) {
            CardModifierManager.addModifier(eligibleCardsList.get(i), new EtherealMod());
            CardModifierManager.addModifier(eligibleCardsList.get(i), new ExhaustMod());
            myCardsList.add(eligibleCardsList.get(i));
        }
        atb(new SelectCardsAction(myCardsList, 1, cardStrings.EXTENDED_DESCRIPTION[0], (cards) -> {
            att(new MakeTempCardInHandAction(cards.get(0), 1, true));
        }));
    }

    @Override
    public void upp() {
        upgradeBaseCost(0);
    }
}