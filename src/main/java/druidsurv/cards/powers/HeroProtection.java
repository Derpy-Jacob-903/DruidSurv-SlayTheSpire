package druidsurv.cards.powers;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.BufferPower;
import druidsurv.cards.AbstractEasyCard;

import static druidsurv.ModFile.makeID;

public class HeroProtection extends AbstractEasyCard {
    public final static String ID = makeID("HeroProtection");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public HeroProtection() {
        super(ID, 2, CardType.POWER, CardRarity.RARE, CardTarget.SELF, "HeroProtection_CardArt");
        baseMagicNumber = magicNumber = 1;
        this.setCardBack(cardSubType.POWER);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new ApplyPowerAction(p, p, new BufferPower(p, magicNumber)));
    }

    @Override
    public void upp() {
        upgradeMagicNumber(1);
    }
}