package druidsurv.cards.bloons;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DemonFormPower;
import druidsurv.cards.AbstractEasyCard;

import static druidsurv.ModFile.makeID;

public class Strengthenator extends AbstractEasyCard {
    public final static String ID = makeID("Strengthenator");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public Strengthenator() {
        super(ID, 1, CardType.POWER, CardRarity.RARE, CardTarget.SELF, "Strengthenator_CardArt");
        tags.add(druidsurv.cards.cardvars.CardTags.BLOON);
        tags.add(druidsurv.cards.cardvars.CardTags.LARGE);
        tags.add(druidsurv.cards.cardvars.CardTags.UNIQUE);
        baseMagicNumber = magicNumber = 1;
        this.setCardBack(cardSubType.BLOON);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new ApplyPowerAction(p, p, (AbstractPower)new DemonFormPower(p, magicNumber), magicNumber, true, AbstractGameAction.AttackEffect.NONE));
    }

    @Override
    public void upp()
    {
        upgradeMagicNumber(1);
    }
}