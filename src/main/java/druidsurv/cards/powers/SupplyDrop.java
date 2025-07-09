package druidsurv.cards.powers;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.atb;

public class SupplyDrop extends AbstractEasyCard {
    public final static String ID = makeID("SupplyDrop");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public SupplyDrop() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF, "SupplyDrop_CardArt");
        baseMagicNumber = magicNumber = 2;
        tags.add(druidsurv.cards.cardvars.CardTags.BCSPOWER);
        this.setCardBack(cardSubType.POWER);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        atb(new DrawCardAction(magicNumber));
    }

    @Override
    public void upp() {
        upgradeBaseCost(0);
    }
}