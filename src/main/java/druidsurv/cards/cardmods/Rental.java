package druidsurv.cards.cardmods;

import basemod.abstracts.AbstractCardModifier;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.unique.LoseEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Rental extends AbstractCardModifier {
    public Rental() {
    }

    @Override
    public String modifyName(String cardName, AbstractCard card) {
        return "Rental " + cardName;
    }

    @Override
    public String modifyDescription(String rawDescription, AbstractCard card) {
        return rawDescription + " NL When this card is drawn, lose 1 Energy.";
    }
    //note: prioritizeAlternateCost defaults to false, so you don't have to override it if you want your resource spent after energy.

    @Override
    public void onDrawn(AbstractCard card) {
        addToBot((AbstractGameAction)new LoseEnergyAction(1));
    }

    @Override
    public AbstractCardModifier makeCopy() {
        return new Rental();
    }
}