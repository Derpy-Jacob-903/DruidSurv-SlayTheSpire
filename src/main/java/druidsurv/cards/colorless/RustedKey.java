package druidsurv.cards.colorless;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.makeInHand;
import static org.apache.commons.lang3.BooleanUtils.and;

public class RustedKey extends AbstractEasyCard {
    public final static String ID = makeID("RustedKey");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public RustedKey() {
        super(ID,0, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF, CardColor.COLORLESS, "NoArt");
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        for (int i = 1; i == magicNumber; i++) {
            AbstractCard tmp = AbstractDungeon.returnTrulyRandomCard();
            while ((!tmp.color.equals(CardColor.COLORLESS)) && (!(tmp.rarity.equals(CardRarity.UNCOMMON) || tmp.rarity.equals(CardRarity.RARE)))) {
                tmp = AbstractDungeon.returnTrulyRandomCard();
            }
            makeInHand(tmp);
        }
    }

    @Override
    public void upp() {
        upgradeMagicNumber(1);
    }
}