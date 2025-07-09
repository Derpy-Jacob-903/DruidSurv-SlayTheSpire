package druidsurv.cards.powers;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;

import static druidsurv.ModFile.makeID;

public class CashDrop extends AbstractEasyCard {
    public final static String ID = makeID("CashDrop");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public CashDrop() {
        super(ID, 0, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF, "CashDrop_CardArt");
        baseMagicNumber = magicNumber = 2;
        exhaust = true;
        this.setCardBack(cardSubType.POWER);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new GainEnergyAction(1));
        if (upgraded) { addToBot((AbstractGameAction)new DrawCardAction(1)); }
    }

    @Override
    public void upp() {
    }
}