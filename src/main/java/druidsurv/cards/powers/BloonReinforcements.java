package druidsurv.cards.powers;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.makeInHand;
import static druidsurv.util.Wiz.returnTrulyRandomPrediCardInCombat;

public class BloonReinforcements extends AbstractEasyCard {
    public final static String ID = makeID("BloonReinforcements");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public BloonReinforcements() {
        super(ID, 1, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.SELF, "BloonReinforcements_Cardart");
        tags.add(druidsurv.cards.cardvars.CardTags.BCSPOWER);
        baseMagicNumber = magicNumber = 2;
        exhaust = true;
        this.setCardBack(cardSubType.POWER);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        for (int i = 0; i < magicNumber; i++) {
            AbstractCard eligibleCardsList = returnTrulyRandomPrediCardInCombat(c -> c.hasTag(druidsurv.cards.cardvars.CardTags.BLOON)
                    && !c.hasTag(druidsurv.cards.cardvars.CardTags.ADVANCED) && !c.hasTag(druidsurv.cards.cardvars.CardTags.LARGE));
            makeInHand(eligibleCardsList);
        }
    }

    @Override
    public void upp() {
        upgradeMagicNumber(1);
    }
}