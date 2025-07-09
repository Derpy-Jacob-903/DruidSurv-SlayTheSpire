package druidsurv.cards.bloons;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.atb;

public class WhiteBloon extends AbstractEasyCard {
    public final static String ID = makeID("WhiteBloon");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public WhiteBloon() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF, "WhiteBloon_CardArt");
        baseBlock = 5;
        tags.add(druidsurv.cards.cardvars.CardTags.BLOON);
        tags.add(druidsurv.cards.cardvars.CardTags.ADVANCED);
        this.setCardBack(cardSubType.BLOON);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        bloonBlck();
        atb(new DrawCardAction(1));
    }

    @Override
    public void upp()
    {
        upgradeBlock(5);
    }
}