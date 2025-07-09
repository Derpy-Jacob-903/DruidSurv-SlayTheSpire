package druidsurv.potions;

import basemod.BaseMod;
import basemod.cardmods.EtherealMod;
import basemod.cardmods.ExhaustMod;
import basemod.helpers.CardModifierManager;
import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.unique.DiscoveryAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.powers.StrengthPower;
import druidsurv.CharacterFile;
import druidsurv.ModFile;
import druidsurv.cards.cardvars.CardTags;

import java.util.ArrayList;
import java.util.Collections;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.*;

public class InstaMonkeyPotion extends AbstractEasyPotion {
    public static String ID = makeID("InstaMonkeyPot");

    public InstaMonkeyPotion() {
        super(ID, PotionRarity.COMMON, PotionSize.CARD, new Color(0.996f, 0.396f, 0.302f, 1f), new Color(0.996f, 0.396f, 0.302f, 1f), null, CharacterFile.Enums.DRUIDSURV, ModFile.characterColor);
    }

    public int getPotency(int ascensionlevel) {
        return 10;
    }

    public void use(AbstractCreature creature) {
        ArrayList<AbstractCard> myCardsList = new ArrayList<>();
        ArrayList<AbstractCard> eligibleCardsList = getCardsMatchingPredicate(c -> c.hasTag(CardTags.MONKEY), true);
        Collections.shuffle(eligibleCardsList);
        for (int i = 0; i < 3; i++) {
            eligibleCardsList.get(i).costForTurn = 0;
            myCardsList.add(eligibleCardsList.get(i));
        }
        atb(new SelectCardsAction(myCardsList, 1, "cardStrings.EXTENDED_DESCRIPTION[0]", (cards) -> {
            att(new MakeTempCardInHandAction(cards.get(0), 1, true));
        }));
    }

    public String getDescription() {
        return strings.DESCRIPTIONS[0] + potency + strings.DESCRIPTIONS[1];
    }

    public void addAdditionalTips() {
        tips.add(new PowerTip(BaseMod.getKeywordTitle(makeID("todo")), BaseMod.getKeywordDescription(makeID("todo"))));
    }
}