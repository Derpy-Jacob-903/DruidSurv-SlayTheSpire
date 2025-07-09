package druidsurv.cards.bloons;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.powers.WeakBloonPower;

import static druidsurv.ModFile.makeID;

public class WeakGas extends AbstractEasyCard {
    public final static String ID = makeID("WeakGasBloon");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public WeakGas() {
        super(ID, 1, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF, "WeakeningGasBloon_CardArt");
        baseMagicNumber = magicNumber = 1;
        tags.add(druidsurv.cards.cardvars.CardTags.BLOON);
        tags.add(druidsurv.cards.cardvars.CardTags.LARGE);
        this.setCardBack(cardSubType.BLOON);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new ApplyPowerAction(p, p, (AbstractPower)new WeakBloonPower(p, magicNumber), magicNumber, true, AbstractGameAction.AttackEffect.NONE));
    }

    @Override
    public void upp()
    {
        upgradeMagicNumber(1);
    }
}