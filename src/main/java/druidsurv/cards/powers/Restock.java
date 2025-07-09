package druidsurv.cards.powers;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.atb;

public class Restock extends AbstractEasyCard {
    public final static String ID = makeID("Restock");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public Restock() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF, "Restock_CardArt");
        baseMagicNumber = magicNumber = 3;
        tags.add(druidsurv.cards.cardvars.CardTags.BCSPOWER);
        this.exhaust = true;
        this.setCardBack(cardSubType.POWER);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        atb(new DrawCardAction(magicNumber));
    }

    @Override
    public void upp() {
        upgradeMagicNumber(1);
    }
}