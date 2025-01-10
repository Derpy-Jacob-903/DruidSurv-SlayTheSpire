package druidsurv.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static druidsurv.CharacterFile.Enums.DRUIDSURV_COLOR;
import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.makeInHand;
import static java.lang.Boolean.logicalOr;
import static org.apache.commons.lang3.BooleanUtils.and;

public class RustedKey extends AbstractEasyCard {
    public final static String ID = makeID("RustedKey");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public RustedKey() {
        super(ID,0, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseMagicNumber = 1;
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