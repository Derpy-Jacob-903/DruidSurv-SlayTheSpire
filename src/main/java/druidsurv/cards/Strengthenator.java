package druidsurv.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.cards.cardvars.CardTags;
import druidsurv.powers.onedelaybloon;
import druidsurv.powers.strengthenator;

import static druidsurv.ModFile.makeID;

public class Strengthenator extends AbstractEasyCard {
    public final static String ID = makeID("Strengthenator");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public Strengthenator() {
        super(ID, 1, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
        tags.add(druidsurv.cards.cardvars.CardTags.BLOON);
        tags.add(druidsurv.cards.cardvars.CardTags.LARGE);
        tags.add(druidsurv.cards.cardvars.CardTags.UNIQUE);
        baseMagicNumber = 30;
        //setBackgroundTexture("druidsurvResources/images/512/bloon_attack.png", "druidsurvResources/images/1024/bloon_attack.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new ApplyPowerAction(p, p, (AbstractPower)new strengthenator(p, magicNumber), magicNumber, true, AbstractGameAction.AttackEffect.NONE));
    }

    @Override
    public void upp()
    {
        upgradeMagicNumber(10);
    }
}